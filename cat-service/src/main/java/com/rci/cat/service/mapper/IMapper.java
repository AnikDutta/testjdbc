package com.rci.cat.service.mapper;

public interface IMapper<R, E> {
	public E convertToEntity(R resource);
	public R convertToResource(E entity);
}