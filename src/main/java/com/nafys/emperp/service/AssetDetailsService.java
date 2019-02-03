package com.nafys.emperp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nafys.emperp.entity.AssetDetails;
import com.nafys.emperp.repository.AssetDetailsRepository;



@Service
public class AssetDetailsService {

	@Autowired
	private AssetDetailsRepository assetDetailsRepository;
	
	public List<AssetDetails> getAssetDetailss(){
		return assetDetailsRepository.findAll();
	}

	public AssetDetails createAssetDetails(AssetDetails assetDetails) {
		return assetDetailsRepository.save(assetDetails);
	}

	public AssetDetails findById(Long id) {
		Optional<AssetDetails> assetDetails = assetDetailsRepository.findById(id);
		if(assetDetails.isPresent()) {
			return assetDetails.get();
		}
		return null;
	}

	public Long deleteAssetDetails(Long id) {
		assetDetailsRepository.deleteById(id);
		return id;
	}
}
