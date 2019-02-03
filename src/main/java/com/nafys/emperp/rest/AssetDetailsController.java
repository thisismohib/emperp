package com.nafys.emperp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nafys.emperp.entity.AssetDetails;
import com.nafys.emperp.service.AssetDetailsService;

@RestController
@RequestMapping("/api")
public class AssetDetailsController {

	@Autowired
	private AssetDetailsService assetDetailsService;
	
	@PostMapping("/assetDetailss")
	public AssetDetails createAssetDetails(@RequestBody AssetDetails assetDetails){
		return assetDetailsService.createAssetDetails(assetDetails);	
	}
	
	@PutMapping("/assetDetailss")
	public AssetDetails updateAssetDetails(@RequestBody AssetDetails assetDetails){
		return assetDetailsService.createAssetDetails(assetDetails);	
	}
	
	@GetMapping("/assetDetailss/{id}")
	public AssetDetails getAssetDetails(@PathVariable Long id){
		return assetDetailsService.findById(id);	
	}
	
	@GetMapping("/assetDetailss")
	public List<AssetDetails> getAssetDetailss(){
		return assetDetailsService.getAssetDetailss();	
	}
	
	@DeleteMapping("/assetDetailss/{id}")
	public Long deleteAssetDetails(@PathVariable Long id){
		return assetDetailsService.deleteAssetDetails(id);	
	}
	
}
