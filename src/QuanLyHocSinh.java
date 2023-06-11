import java.util.ArrayList;

public class QuanLyHocSinh {
    private ArrayList<HocSinh> danhSachHocSinh;

    public QuanLyHocSinh() {
        danhSachHocSinh = new ArrayList<>();
    }

    public void themHocSinh(HocSinh hocSinh) {
        danhSachHocSinh.add(hocSinh);
    }

    public ArrayList<HocSinh> danhSachHocSinh() {
        return danhSachHocSinh;
    }

    public ArrayList<HocSinh> danhSachHocSinh20Tuoi() {
        ArrayList<HocSinh> danhSachHocSinh20Tuoi = new ArrayList<>();

        for (HocSinh hocSinh : danhSachHocSinh) {
            if (hocSinh.getTuoi() == 20) {
                danhSachHocSinh20Tuoi.add(hocSinh);
            }
        }

        return danhSachHocSinh20Tuoi;
    }

    public int soLuongHocSinh23TuoiQueDN() {
        int count = 0;

        for (HocSinh hocSinh : danhSachHocSinh) {
            if (hocSinh.getTuoi() == 23 && hocSinh.getQueQuan().equalsIgnoreCase("Da Nang")) {
                count++;
            }
        }

        return count;
    }
}

