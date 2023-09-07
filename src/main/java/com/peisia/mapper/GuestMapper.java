package com.peisia.mapper;

import java.util.List;

import com.peisia.domain.GuestVO;

public interface GuestMapper {
	public List<GuestVO> getList(int limitIndex);
	public GuestVO read(long bno);
	public void del(long bno);
	public void write(GuestVO gvo);
	public void modify(GuestVO gvo);
}
