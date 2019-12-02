package com.example.springboot.service;

import com.example.springboot.dao.OscMapper;
import com.example.springboot.domain.Osc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OscService {

        @Autowired
        private OscMapper oscMapper;

        public List<Osc> getAll(){
                return oscMapper.getAll();
        }

        public List<Osc> getFromName(String name){
                return oscMapper.getFromName(name);
        }

        public void add(Osc osc){
                oscMapper.insert(osc);
        }

}

