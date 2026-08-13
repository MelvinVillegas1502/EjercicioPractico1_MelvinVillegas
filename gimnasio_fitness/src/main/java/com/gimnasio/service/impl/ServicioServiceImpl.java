package com.gimnasio.service.impl;

import com.gimnasio.domain.Servicio;
import com.gimnasio.repository.ServicioRepository;
import com.gimnasio.service.ServicioService;
import com.gimnasio.service.ServicioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Servicio> getServicios() {
        return servicioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Servicio getServicio(Servicio servicio) {
        return servicioRepository.findById(servicio.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Servicio servicio) {
        servicioRepository.save(servicio);
    }

    @Override
    @Transactional
    public void delete(Servicio servicio) {
        servicioRepository.delete(servicio);
    }
}