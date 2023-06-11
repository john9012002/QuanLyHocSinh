import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuanLyHocSinhUI extends JFrame implements ActionListener {
    private JTextField tfHoTen, tfTuoi, tfQueQuan;
    private JButton btnThem, btnHienThi20Tuoi, btnSoLuong23TuoiQueDN;
    private JTextArea taDanhSachHocSinh;
    private QuanLyHocSinh quanLyHocSinh;

    public QuanLyHocSinhUI() {
        setTitle("Quản lý hồ sơ học sinh");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panelMain = new JPanel(new BorderLayout());

        JPanel panelNhapLieu = new JPanel(new GridLayout(4, 2));
        JLabel lbHoTen = new JLabel("Họ tên:");
        tfHoTen = new JTextField(30);
        JLabel lbTuoi = new JLabel("Tuổi:");
        tfTuoi = new JTextField(30);
        JLabel lbQueQuan = new JLabel("Quê quán:");
        tfQueQuan = new JTextField(30);
        btnThem = new JButton("Thêm mới");
        btnThem.addActionListener(this);
        panelNhapLieu.add(lbHoTen);
        panelNhapLieu.add(tfHoTen);
        panelNhapLieu.add(lbTuoi);
        panelNhapLieu.add(tfTuoi);
        panelNhapLieu.add(lbQueQuan);
        panelNhapLieu.add(tfQueQuan);
        panelNhapLieu.add(btnThem);

        JPanel panelDanhSach = new JPanel(new BorderLayout());
        JLabel lbDanhSachHocSinh = new JLabel("Danh sách học sinh:");
        taDanhSachHocSinh = new JTextArea(15, 40);
        taDanhSachHocSinh.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taDanhSachHocSinh);
        panelDanhSach.add(lbDanhSachHocSinh, BorderLayout.NORTH);
        panelDanhSach.add(scrollPane, BorderLayout.CENTER);

        JPanel panelChucNang = new JPanel(new FlowLayout());
        btnHienThi20Tuoi = new JButton("Hiển thị học sinh 20 tuổi");
        btnHienThi20Tuoi.addActionListener(this);
        btnSoLuong23TuoiQueDN = new JButton("Số lượng học sinh 23 tuổi quê ở Đà Nẵng");
        btnSoLuong23TuoiQueDN.addActionListener(this);
        panelChucNang.add(btnHienThi20Tuoi);
        panelChucNang.add(btnSoLuong23TuoiQueDN);

        quanLyHocSinh = new QuanLyHocSinh();

        panelMain.add(panelNhapLieu, BorderLayout.NORTH);
        panelMain.add(panelDanhSach, BorderLayout.CENTER);
        panelMain.add(panelChucNang, BorderLayout.SOUTH);

        add(panelMain);

        setVisible(true);
    }

    public static void main(String[] args) {
        new QuanLyHocSinhUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnThem) {
            String hoTen = tfHoTen.getText();
            int tuoi = Integer.parseInt(tfTuoi.getText());
            String queQuan = tfQueQuan.getText();

            HocSinh hocSinh = new HocSinh(hoTen, tuoi, queQuan);

            quanLyHocSinh.themHocSinh(hocSinh);

            tfHoTen.setText("");
            tfTuoi.setText("");
            tfQueQuan.setText("");

            int lastIndex = quanLyHocSinh.danhSachHocSinh().size() - 1;
            taDanhSachHocSinh.append(quanLyHocSinh.danhSachHocSinh().get(lastIndex).getHoTen() +
                                     "\t" + quanLyHocSinh.danhSachHocSinh().get(lastIndex).getTuoi() +
                                     "\t" + quanLyHocSinh.danhSachHocSinh().get(lastIndex).getQueQuan() + "\n");
        } else if (e.getSource() == btnHienThi20Tuoi) {
            taDanhSachHocSinh.setText("");

            for (HocSinh hocSinh : quanLyHocSinh.danhSachHocSinh20Tuoi()) {
                taDanhSachHocSinh.append(hocSinh.getHoTen() + "\n");
            }
        } else if (e.getSource() == btnSoLuong23TuoiQueDN) {
            int soLuong = quanLyHocSinh.soLuongHocSinh23TuoiQueDN();

            JOptionPane.showMessageDialog(null, "Số lượng học sinh 23 tuổi quê ở Đà Nẵng là: " + soLuong);
        }
    }
}

