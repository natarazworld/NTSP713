package com.cb.service;

import com.ipl.external.IIPLScoreComp;

public class CrickBuzzScoreMgmtServiceImpl implements ICrickBuzzScoreMgmtService {
	private IIPLScoreComp  extComp;
	

	public CrickBuzzScoreMgmtServiceImpl(IIPLScoreComp extComp) {
		this.extComp = extComp;
	}


	@Override
	public String fetchScore(int mid) {
		//use external comp ref
		return extComp.getScore(mid) ;
	}

}
