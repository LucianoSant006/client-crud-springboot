package Client.Api_Restfull_Client.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Genericmapper {

    @Autowired
    private ModelMapper modelMapper;

    public <D,E> D entityToDto(E entity,Class<D> dtoClass){
        return modelMapper.map(entity,dtoClass);
    }
    public <E,D> E dtoToEntity(D dto, Class<E> entityClass){
        return modelMapper.map(dto, entityClass);
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }
}
