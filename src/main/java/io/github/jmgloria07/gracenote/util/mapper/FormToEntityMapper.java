package io.github.jmgloria07.gracenote.util.mapper;

public interface FormToEntityMapper<F, E> {
	
	public E mapFormToEntity(F form);

}
