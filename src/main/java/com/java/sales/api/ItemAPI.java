package com.java.sales.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.sales.api.output.ItemOutput;
import com.java.sales.dto.ItemDTO;
import com.java.sales.service.IItemService;

@RestController
public class ItemAPI {

	@Autowired
	private IItemService itemService;
	
	@GetMapping(value = "/web/item/list")
	public ItemOutput getListItem(@RequestParam(value = "page",required = false) Integer page,
								@RequestParam(value = "limit",required = false)Integer limit) {
		ItemOutput resault=new ItemOutput();
		if(page != null & limit != null) {
			Pageable pageable=PageRequest.of(page-1,limit);
			resault.setResaults(itemService.findAllByOrderByIdDesc(pageable));
			resault.setTotalPgae((int) Math.ceil(itemService.count())/limit);
			resault.setPage(page);
		}else {
			resault.setResaults(itemService.findAllByOrderByIdDesc());
		}
		
		return resault;
	}
	@GetMapping(value = "/web/item/id")
	public ItemDTO getItem(@RequestParam("id") Long id) {		
		return itemService.findOneById(id);
	}
	@GetMapping(value = "/web/item/classify")
	public ItemOutput getItemClassify(@RequestParam("code") String classifyCode) {
		ItemOutput resault=new ItemOutput();
		resault.setResaults(itemService.findAllByClassifysOrderByIdDesc(classifyCode));
		return resault;
	}
	@PostMapping(value = "/api/admin/item")
	public ItemDTO addItem(@RequestBody ItemDTO dto) {
		return itemService.save(dto);
	}
	@PutMapping(value = "/api/admin/item")
	public ItemDTO updateItem(@RequestBody ItemDTO dto) {
		return itemService.save(dto);
	}
	@DeleteMapping(value = "/api/admin/item")
	public void deleteItem(@RequestBody long[] ids) {
		itemService.delete(ids);
	}
}
