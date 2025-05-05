package com.integracion_comunitaria.service.impl;

import com.integracion_comunitaria.model.Portfolio;
import com.integracion_comunitaria.model.Attachment;
import com.integracion_comunitaria.repository.PortfolioRepository;
import com.integracion_comunitaria.repository.AttachmentRepository;
import com.integracion_comunitaria.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Override
    public List<Portfolio> getAllPortfolios() {
        return portfolioRepository.findAll();
    }

    @Override
    public Optional<Portfolio> getPortfolioById(Integer id) {
        return portfolioRepository.findById(id);
    }

    @Override
    public Portfolio createPortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    @Override
    public Optional<Portfolio> updatePortfolio(Integer id, Portfolio portfolio) {
        return portfolioRepository.findById(id).map(existing -> {
            existing.setName(portfolio.getName());
            existing.setDescription(portfolio.getDescription());
            existing.setIdProvider(portfolio.getIdProvider());
            existing.setIdUserUpdate(portfolio.getIdUserUpdate());
            existing.setDateUpdate(new java.util.Date());
            return portfolioRepository.save(existing);
        });
    }

    @Override
    public boolean deletePortfolio(Integer id) {
        return portfolioRepository.findById(id).map(p -> {
            portfolioRepository.delete(p);
            return true;
        }).orElse(false);
    }

    @Override
    public List<Attachment> getAttachmentsByPortfolioId(Integer id) {
        return attachmentRepository.findByPortfolioIdPortfolio(id);
    }
}

