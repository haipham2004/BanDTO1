package com.example.OnTapDTO1.responese;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BanResponse {
    private int id;

    private String ma;

    private String ten;

    private String soThich;

    private int gioiTinh;

    private int idMoiQuanHe;

    private String tenMoiQuanHe;
}
