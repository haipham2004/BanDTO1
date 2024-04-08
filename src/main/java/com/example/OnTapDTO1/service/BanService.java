package com.example.OnTapDTO1.service;

import com.example.OnTapDTO1.entity.Ban;
import com.example.OnTapDTO1.responese.BanResponse;

import java.util.List;

public interface BanService {
    public List<BanResponse> getAll();
    public Ban getOne(int id);
    public boolean add(Ban ban);
    public boolean update(Ban ban);
    public boolean delete(Ban ban);
}
