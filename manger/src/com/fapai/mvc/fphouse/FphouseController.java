package com.fapai.mvc.fphouse;

import com.platform.annotation.Controller;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;
import com.platform.mvc.base.BaseModel;
import com.jfinal.log.Log;

import java.io.File;
import java.util.List;

import com.fapai.mvc.picuphouse.PicUpHouse;
import com.jfinal.aop.Before;

/**
 * XXX 管理	
 * 描述：
 * 
 * /fapai/fphouse
 * /fapai/fphouse/save
 * /fapai/fphouse/edit
 * /fapai/fphouse/update
 * /fapai/fphouse/view
 * /fapai/fphouse/delete
 * /common/fphouse/add.html
 * 
 */
@Controller("/fapai/fphouse")
public class FphouseController extends BaseController {

	@SuppressWarnings("unused")
	private static final Log log = Log.getLog(FphouseController.class);
	
	private FphouseService fphouseService;
	
	/**
	 * 列表
	 */
	public void index() {
		paging(ConstantInit.db_dataSource_main, splitPage, BaseModel.sqlId_splitPageSelect, Fphouse.sqlId_splitPageFrom);
		render("/fapai/fphouse/list.html");
	}
	
	/**
	 * 保存
	 */
	@Before(FphouseValidator.class)
	public void save() {
		
		String fileids[] =getParas("fileids");
		String fileindex[] =getParas("fileindex");
		Fphouse fphouse=getModel(Fphouse.class);
		fphouse.setIs_delete(0);
		fphouse.saveRandomId();
		fphouseService.saveImage(fileids,fileindex,fphouse);
		forwardAction("/fapai/fphouse/backOff");
	}
	
	/**
	 * 准备更新
	 */
	public void edit() {
		Fphouse fphouse = Fphouse.dao.findById(getPara());
		List<PicUpHouse> picList =  fphouseService.getImage(fphouse);
		// Fphouse.dao.find(sql)
		setAttr("fphouse", fphouse);
		setAttr("fileList", picList);

		render("/fapai/fphouse/update.html");
	}
	
	/**
	 * 更新
	 */
	@Before(FphouseValidator.class)
	public void update() {
		Fphouse fphouse=getModel(Fphouse.class);
		fphouse.update();
		String isupdateImge =getPara("isupdateImge");
		if("true".equals(isupdateImge)) {
			String fileids[] =getParas("fileids");
			String fileindex[] =getParas("fileindex");
			fphouseService.deleteImage(fphouse);
			fphouseService.saveImage(fileids,fileindex,fphouse);
		}
		
		forwardAction("/fapai/fphouse/backOff");
	}

	/**
	 * 查看
	 */
	public void view() {
		Fphouse fphouse = Fphouse.dao.findById(getPara());
		List<PicUpHouse> picList =  fphouseService.getImage(fphouse);
		// Fphouse.dao.find(sql)
		setAttr("fphouse", fphouse);
		setAttr("fileList", picList);
		render("/fapai/fphouse/view.html");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		fphouseService.baseDelete(Fphouse.table_name, getPara() == null ? ids : getPara());
		forwardAction("/fapai/fphouse/backOff");
	}
	
}