package com.example.addressbook.repository;

import com.example.addressbook.entity.Address;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMybatisRepository {

    Optional<Address> findById(long idx);

    List<Map<String, Object>> getList(Map<String, Object> paramMap);

    int listCnt(Map<String, Object> paramMap);


}
