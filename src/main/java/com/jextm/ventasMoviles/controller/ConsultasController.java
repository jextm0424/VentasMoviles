package com.jextm.ventasMoviles.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jextm.ventasMoviles.entity.Ubigeo;
import com.jextm.ventasMoviles.entity.Venta;
import com.jextm.ventasMoviles.service.ClienteService;
import com.jextm.ventasMoviles.service.GiroService;
import com.jextm.ventasMoviles.service.MaterialService;
import com.jextm.ventasMoviles.service.PersonalService;
import com.jextm.ventasMoviles.service.UbigeoService;
import com.jextm.ventasMoviles.service.VentaService;

@Controller
public class ConsultasController {
	@Autowired
	private VentaService ventaService;
	@Autowired
	private UbigeoService ubigeoService;
	@Autowired
	private PersonalService personalService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private MaterialService materialService;
	@Autowired
	private GiroService giroService;

	@SuppressWarnings({ "deprecation", "unchecked" })
	@RequestMapping(value="/consulta")
	public ModelAndView index(@RequestParam(value="tipo",required=false)String tipo,
			@RequestParam(value="parametro",required=false)String parametro,
			@RequestParam(value="export",required=false) String export,
			HttpServletResponse response){
		HSSFWorkbook wb = null;
		ModelAndView model = new ModelAndView("consulta");
		model.addObject("vendedores", new JSONArray(personalService.finAll()));
		model.addObject("clientes", new JSONArray(clienteService.getClientes()).toString());
		model.addObject("materiales", new JSONArray(materialService.getAll()).toString());
		model.addObject("giros", new JSONArray(giroService.getAll()).toString());
		model.addObject("ubigeos", new JSONArray(ubigeoService.getAll()).toString());
		if (parametro==null || parametro.trim().equals("")) {
			return model;
		}
		try{
			switch (tipo) {
			case "VE":
				model.addObject("lista", ventaService.findByVendedor(Integer.parseInt(parametro)));
				break;
			case "CL":
				model.addObject("lista", ventaService.findByCliente(Integer.parseInt(parametro)));
				break;
			case "MO":
				model.addObject("lista", ventaService.findByModulo(parametro));
				break;
			case "PR":
				model.addObject("lista", ventaService.findByProducto(Integer.parseInt(parametro)));
				break;
			case "DI":
				model.addObject("lista", ventaService.findByDia(Integer.parseInt(parametro)));
				break;
			case "GI":
				model.addObject("lista", ventaService.findByGiro(parametro.charAt(0)));
				break;
			case "DS":
				model.addObject("lista", ventaService.findByDistrito(parametro));
				break;
			case "FE":
				String[] formato = parametro.split("-");
				Date fecha = new Date();
				fecha.setYear(Integer.parseInt(formato[0])-1900);
				fecha.setMonth((Integer.parseInt(formato[1])-1));
				fecha.setDate((Integer.parseInt(formato[2])));
				model.addObject("lista", ventaService.findByDayBetween(fecha));
				break;
			default:
				model.addObject("lista", ventaService.getAll());
				break;
			}
			if (export != null) {
				wb = generateExcel((List<Venta>)model.getModel().get("lista"),response);
				response.setContentType("application/xls");
				response.addHeader("Content-Disposition", "attachment; filename=reporte.xls");
				try {
					response.getOutputStream().flush();
					response.getOutputStream().close();
				} catch (IOException e) {
					System.out.println("Error Al generar Excel: "+e.getMessage());
				}
				return null;
			}
		}catch (NumberFormatException|IOException e) {
			System.out.println("Error al convertir a numero o Al generar Excel"+e.getMessage());
		}
		return model;
	}
	
	@SuppressWarnings("deprecation")
	private HSSFWorkbook generateExcel(List<Venta> ventas, HttpServletResponse response)throws IOException{
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("Consultas");
		sheet.setColumnWidth(1,10000);
		sheet.setColumnWidth(2,10000);
		sheet.setColumnWidth(3,10000);
		sheet.setColumnWidth(6,10000);
		sheet.setColumnWidth(7,10000);
		CellStyle cabecera = wb.createCellStyle();
		cabecera.setAlignment(CellStyle.ALIGN_CENTER);
		cabecera.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		cabecera.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
		cabecera.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		cabecera.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);

		cell.setCellValue("Código");
		cell.setCellStyle(cabecera);
		cell = row.createCell(1);
		cell.setCellValue("Fecha");
		cell.setCellStyle(cabecera);
		cell = row.createCell(2);
		cell.setCellValue("Vendedor");
		cell.setCellStyle(cabecera);
		cell = row.createCell(3);
		cell.setCellValue("Cliente");
		cell.setCellStyle(cabecera);
		cell = row.createCell(4);
		cell.setCellValue("Peso");
		cell.setCellStyle(cabecera);
		cell = row.createCell(5);
		cell.setCellValue("Precio");
		cell.setCellStyle(cabecera);
		cell = row.createCell(6);
		cell.setCellValue("Distrito");
		cell.setCellStyle(cabecera);
		cell = row.createCell(7);
		cell.setCellValue("Giro");
		cell.setCellStyle(cabecera);
		for(int i=0;i<ventas.size();i++){
			Venta venta = ventas.get(i);
			row = sheet.createRow((i+1));
			cell = row.createCell(0);
			cell.setCellType(CellType.NUMERIC);
			cell.setCellValue(venta.getIdVenta());
			cell.setCellStyle(cabecera);
			cell = row.createCell(1);
			CellStyle cellStyle = wb.createCellStyle();
			CreationHelper createHelper = wb.getCreationHelper();
			cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			cell.setCellValue(venta.getFechaVenta());
			cell.setCellStyle(cellStyle);
			cell = row.createCell(2);
			cell.setCellValue(venta.getCliente().getPersonal().getApellido()+", "+venta.getCliente().getPersonal().getNombre());
			cell.setCellStyle(cabecera);
			cell = row.createCell(3);
			cell.setCellValue(venta.getCliente().getApellido()+", "+venta.getCliente().getNombre());
			cell.setCellStyle(cabecera);
			cell = row.createCell(4);
			cell.setCellType(CellType.NUMERIC);
			cell.setCellValue(venta.getPesoTotal());
			cell.setCellStyle(cabecera);
			cell = row.createCell(5);
			cell.setCellType(CellType.NUMERIC);
			cell.setCellValue(venta.getPrecioTotal());
			cell.setCellStyle(cabecera);
			cell = row.createCell(6);
			List<Ubigeo> ubigeos = ubigeoService.getAll();
			outerloop : for(int x=0;x<ubigeos.size();x++){
				int nroUbigeo = 0;
				try{
					nroUbigeo = Integer.parseInt(venta.getCliente().getUbigeo());
					if (ubigeos.get(x).getIdUbigeo() == nroUbigeo) {
						cell.setCellValue(ubigeos.get(x).getDescripcion());
						break outerloop;
					}else if((x+1)==ubigeos.size() && cell.getStringCellValue().toString().equals("")){
						cell.setCellValue(venta.getCliente().getUbigeo());
					}
				}catch(NumberFormatException e){
					System.out.println("Error al convertir a número "+ e.getMessage());
				}
			}
			cell.setCellStyle(cabecera);
			cell = row.createCell(7);
			cell.setCellValue(venta.getCliente().getGiro().getGiro());
			cell.setCellStyle(cabecera);
			if ((i+1)==ventas.size()) {
				row = sheet.createRow(i+2);
				cell = row.createCell(4);
				cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
				cell.setCellFormula("SUM(E2:E"+(i+2)+")");
				cell.setCellStyle(cabecera);
				cell = row.createCell(5);
				cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
				cell.setCellFormula("SUM(F2:F"+(i+2)+")");
				cell.setCellStyle(cabecera);
			}
		}
		wb.write(response.getOutputStream());
		wb.close();
		return wb;
	}
}
