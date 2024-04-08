package com.example.OnTapDTO1.controller;

import com.example.OnTapDTO1.entity.Ban;
import com.example.OnTapDTO1.entity.MoiQuanHe;
import com.example.OnTapDTO1.repository.MoiQuanHeRepository;
import com.example.OnTapDTO1.request.BanRequest;
import com.example.OnTapDTO1.responese.BanResponse;
import com.example.OnTapDTO1.service.Imp.BanImp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", value = {
        "/HienThi",
        "/Detail",
        "/ViewUpdate",
        "/Add",
        "/Update",
        "/Delete"
})
public class Servlet extends HttpServlet {
    List<BanResponse> listB = new ArrayList<>();
    BanImp service = new BanImp();
    List<MoiQuanHe> listMQH = new ArrayList<>();
    MoiQuanHeRepository service2 = new MoiQuanHeRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("HienThi")) {
            HienThi(request, response);
        } else if (uri.contains("Detail")) {
            Detail(request, response);
        } else if (uri.contains("Delete")) {
            Delete(request, response);
        } else if (uri.contains("ViewUpdate")) {
            ViewUpdate(request, response);
        }
    }


    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("Add")) {
            Add(request, response);
        } else if (uri.contains("Update")) {
            Update(request, response);
        }
    }

    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listB = service.getAll();
        request.setAttribute("listB", listB);
        listMQH = service2.getAll();
        request.setAttribute("listMQH", listMQH);
        pagination(listB,request,response);
        request.getRequestDispatcher("/view/ListBan.jsp").forward(request, response);
    }


    private void ViewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Ban b = service.getOne(id);
        request.setAttribute("b", b);
        listB = service.getAll();
        request.setAttribute("listB", listB);
        listMQH = service2.getAll();
        request.setAttribute("listMQH", listMQH);
        request.getRequestDispatcher("/view/Update.jsp").forward(request, response);
    }

    private void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Ban b = service.getOne(id);
        service.delete(b);
        response.sendRedirect("/HienThi");
    }

    private void Detail(HttpServletRequest request, HttpServletResponse response) {
    }


    private void Update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        BanRequest banRequest = new BanRequest();
//        BeanUtils.populate(banRequest,request.getParameterMap());
//        System.out.println("Haha update: "+banRequest);
//        int id=Integer.parseInt(request.getParameter("id"));
//        banRequest.setId(id);
//        int idMoiQuanHe=Integer.parseInt(request.getParameter("idMoiQuanHe"));
//        banRequest.setIdMoiQuanHe(idMoiQuanHe);
//        System.out.println("HAHA UPDATE: "+banRequest);
//        service.updateRequest(banRequest);
//        response.sendRedirect("/HienThi");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String soThich = request.getParameter("soThich");
        String gioiTinh = request.getParameter("gioiTinh");
        int id = Integer.parseInt(request.getParameter("id"));
        int idMoiQuanHe = Integer.parseInt(request.getParameter("idMoiQuanHe"));
        System.out.println("idMQH "+idMoiQuanHe);
        BanRequest ban=BanRequest.builder().id(id).ma(ma).ten(ten).soThich(soThich).gioiTinh(Integer.parseInt(gioiTinh)).idMoiQuanHe(idMoiQuanHe).build();
        service.updateRequest(ban);
        response.sendRedirect("/HienThi");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
//        BanRequest banRequest = new BanRequest();
//        BeanUtils.populate(banRequest, request.getParameterMap());
//        int idMoiQuanHe = Integer.parseInt(request.getParameter("idMoiQuanHe"));
//        banRequest.setId(idMoiQuanHe);
//        System.out.println("Haha: " + banRequest);
//        service.addRequest(banRequest);
//        response.sendRedirect("/HienThi");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String soThich = request.getParameter("soThich");
        String gioiTinh = request.getParameter("gioiTinh");
        int idMoiQuanHe = Integer.parseInt(request.getParameter("idMoiQuanHe"));
        BanRequest ban=BanRequest.builder().ma(ma).ten(ten).soThich(soThich).gioiTinh(Integer.parseInt(gioiTinh)).idMoiQuanHe(idMoiQuanHe).build();
        service.addRequest(ban);
        response.sendRedirect("/HienThi");
    }

    public void pagination(List<BanResponse> list, HttpServletRequest req, HttpServletResponse resp){
        List<BanResponse> bans = list;
        // phân trang
        int pageNumber = 1; //  trang hiện tại
        int pageSize = 3; // số lượng sản phẩm trên mỗi trang
        int totalProducts = bans.size(); //tổng sản phẩm hiện có
        int totalPages = (int) Math.ceil((double) totalProducts / pageSize); // tổng số trang để chứa sản phẩm

        String pageParam = req.getParameter("page"); // lấy ra trang hiện tại
        if (pageParam != null && !pageParam.isEmpty()) {
            pageNumber = Integer.parseInt(pageParam); // check và gán cho số trang
        }
        if (pageNumber < 1) {
            pageNumber = 1;
        } else if (pageNumber > totalPages) {
            // nếu số trang hiện tại lớn hơn tổng số trang để chứa sản phẩm thì
            // gán trang hiện tại bằng tổng trang , tức là trang cuối cùng
            pageNumber = totalPages;
        }

        int startIndex = (pageNumber - 1) * pageSize; // vị trí bắt đầu lấy ra sản phẩm để in lên trang
        int endIndex = Math.min(startIndex + pageSize, totalProducts);
        // vị trí cuối cùng, nếu startIndex + pageSize vượt quá phần tử trong mảng
        // thì lấy số lượng phẩn tử trong mảng làm điểm cuối cùng

        List<BanResponse> currentPageProducts = bans.subList(startIndex, endIndex);
        // lấy ra list sản phẩm và dùng sublist để lấy ra 12 sản phẩm bằng start và end

        // gửi lên server và in ra thôi
        req.setAttribute("currentPageProducts", currentPageProducts);
        req.setAttribute("pageNumber", pageNumber);
        req.setAttribute("totalPages", totalPages);
    }
}
