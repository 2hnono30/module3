use quanlybanhang;
-- CAU 1)  In ra danh sách các sản phẩm (MASP,TENSP) do “Trung Quốc” sản xuất.
SELECT MASP,TENSP
FROM SANPHAM
WHERE NUOCSX='TRUNG QUOC';
-- CAU 2)  In ra danh sách các sản phẩm (MASP, TENSP) có đơn vị tính là “cây”, ”quyển”.
SELECT	MASP,TENSP
FROM SANPHAM
WHERE DVT='CAY' OR DVT='QUYEN';
-- CAU 3)  In ra danh sách các sản phẩm (MASP,TENSP) có mã sản phẩm bắt đầu là “B” và kết thúc là “01”.
SELECT MASP,TENSP
FROM SANPHAM
WHERE MASP LIKE 'B%01';
-- CAU 4) In ra danh sách các sản phẩm (MASP,TENSP) do “Trung Quốc” sản xuất có giá từ 20.000 đến 30.000.
SELECT MASP,TENSP
FROM SANPHAM
WHERE NUOCSX='TRUNG QUOC' AND GIA BETWEEN 30000 AND 40000;
-- CAU 5) In ra danh sách các sản phẩm (MASP,TENSP) do “Trung Quốc” hoặc “Thái Lan” sản xuất có giá từ 20.000 đến 30.000.
SELECT MASP,TENSP
FROM SANPHAM
WHERE (NUOCSX='TRUNG QUOC' OR NUOCSX='THAI LAN') AND GIA BETWEEN 20000 AND 30000;
-- CAU 6) In ra các số hóa đơn, trị giá hóa đơn bán ra trong ngày 1/1/2007 và ngày 2/1/2007.
SELECT SoHoaDon,TRIGIA
FROM HOADON
WHERE NgayMuaHang='2007/1/1' OR NgayMuaHang='2007/1/2';
-- CAU 7)  In ra các số hóa đơn, trị giá hóa đơn trong tháng 1/2007, sắp xếp theo ngày (tăng dần) và trị giá của óa đơn (giảm dần).
SELECT SoHoaDon,TRIGIA
FROM HOADON
WHERE MONTH(NgayMuaHang)=1 AND YEAR(NgayMuaHang)=2007
ORDER BY  NgayMuaHang ASC,TRIGIA DESC;
-- CAU 8) In ra danh sách các khách hàng (MAKH, HOTEN) đã mua hàng trong ngày 1/1/2007.
SELECT	A.MAKH,HOTEN
FROM HOADON A, KHACHHANG B
WHERE	A.MAKH=B.MAKH AND NgayMuaHang='2007/1/1';
-- CAU 9) In ra số hóa đơn, trị giá các hóa đơn do nhân viên có tên “Nguyễn Văn B” lập trong ngày 10/10/2006. 
SELECT	SoHoaDon,TRIGIA
FROM HOADON A, NHANVIEN B
WHERE	A.MANV=B.MANV AND NgayMuaHang='2006/10/28' AND HOTEN='NGUYEN VAN B' ;
-- CAU 10) In ra danh sách các sản phẩm (MASP,TENSP) được khách hàng có tên “Nguyễn Văn A” mua trong háng 10/2006.
SELECT sanpham.MaSP,sanpham.TenSP,hoadon.MaKH
FROM hoadon,khachhang
join cthd,sanpham 
WHERE hoadon.MaKH = KHACHHANG.MaKH AND hoadon.SoHoaDon = cthd.SoHD AND cthd.MaSP = sanpham.MaSP AND
MONTH(NgayMuaHang) = 10 AND YEAR(NgayMuaHang) = 2006 AND HOTEN = 'NGUYEN VAN A' ;
-- CAU 11) Tìm các số hóa đơn đã mua sản phẩm có mã số “BB01” hoặc “BB02”.
SELECT	SOHD
FROM CTHD
WHERE	MASP='BB01'OR MASP='BB02';
-- CAU 12) Tìm các số hóa đơn đã mua sản phẩm có mã số “BB01” hoặc “BB02”, mỗi sản phẩm mua với số ượng từ 10 đến 20.
SELECT	SOHD
FROM CTHD
WHERE (MASP='BB01'OR MASP='BB02') AND SoLuong BETWEEN 10 AND 20;
-- CAU 13)  Tìm các số hóa đơn mua cùng lúc 2 sản phẩm có mã số “BB01” và “BB02”, mỗi sản phẩm mua với số ượng từ 10 đến 20.
SELECT	SOHD
FROM CTHD
WHERE SoLuong BETWEEN 10 AND 20 AND MASP='BB01'
AND SOHD IN ( SELECT SOHD
FROM CTHD
WHERE	MASP='BB02');
-- CAU 14) In ra danh sách các sản phẩm (MASP,TENSP) do “Trung Quốc” sản xuất hoặc các sản phẩm được bán a trong ngày 1/1/2007.
SELECT	DISTINCT A.MASP,TENSP
FROM SANPHAM A, HOADON B, CTHD C
WHERE NUOCSX='TRUNG QUOC' OR (B.SoHoaDon=C.SOHD AND C.MASP=A.MASP AND NgayMuaHang='2007/1/1') ;
-- CAU 15) In ra danh sách các sản phẩm (MASP,TENSP) không bán được.
SELECT	MASP, TENSP
FROM SANPHAM
WHERE MASP NOT IN (	SELECT	MASP FROM CTHD);
-- CAU 16)  In ra danh sách các sản phẩm (MASP,TENSP) không bán được trong năm 2006.
SELECT	MASP, TENSP
FROM SANPHAM
WHERE MASP NOT IN (	SELECT MASP FROM CTHD , HOADON 
WHERE CTHD.SOHD=HOADON.SoHoaDon AND YEAR(NgayMuaHang)=2006);
-- CAU 17) In ra danh sách các sản phẩm (MASP,TENSP) do “Trung Quốc” sản xuất không bán được trong năm 2006.
SELECT	MASP, TENSP
FROM SANPHAM
WHERE NUOCSX='TRUNG QUOC' AND
MASP NOT IN (SELECT	MASP FROM CTHD,hoadon
WHERE CTHD.SOHD=HOADON.SoHoaDon AND YEAR(NgayMuaHang)=2006);
-- CAU 18) Có bao nhiêu hóa đơn không phải của khách hàng đăng ký thành viên mua?
SELECT	COUNT(SoHoaDon)
FROM HOADON
WHERE MAKH IS NULL;
-- CAU 19) Cho biết trị giá hóa đơn cao nhất, thấp nhất là bao nhiêu ?
SELECT	MAX(TRIGIA) ,MIN(TRIGIA)  
FROM HOADON;
-- SELECT	COUNT(DISTINCT MASP)
-- FROM hoadon , CTHD 
-- WHERE hoadon.SoHoaDon=CTHD.SoHD AND YEAR(NgayMuaHang)=2006;
-- CAU 20)Trị giá trung bình của tất cả các hóa đơn được bán ra trong năm 2006 là bao nhiêu?
SELECT	AVG(TRIGIA)
FROM HOADON 
WHERE YEAR(NgayMuaHang)=2006;

-- CAU 21)Tính doanh thu bán hàng trong năm 2006.
SELECT	SUM(TRIGIA) 
FROM HOADON
WHERE YEAR(NgayMuaHang)=2006;

-- CAU 22)Tìm số hóa đơn có trị giá cao nhất trong năm 2006.
SELECT	MAX(TRIGIA) 
FROM HOADON where year(NgayMuaHang) = 2006;
-- CAU 23)Tìm họ tên khách hàng đã mua hóa đơn có trị giá cao nhất trong năm 2006.
select khachhang.HoTen,hoadon.MaKH,max(hoadon.TriGia) 
from hoadon,khachhang where year(NgayMuaHang) = 2006 and khachhang.MaKH = hoadon.MaKH;
-- CAU 24). In ra danh sách 3 khách hàng (MAKH, HOTEN) có doanh số cao nhất.
select MaKH,HoTen,max(DoanhSo) 
from khachhang;
-- CAU 27)In ra danh sách các sản phẩm (MASP, TENSP) do “Trung Quốc” sản xuất có giá bằng 1 trong 3 mức iá thấp nhất (của sản phẩm do “Trung Quốc” sản xuất).

-- CAU 28)* In ra danh sách 3 khách hàng (MAKH, HOTEN) có doanh số cao nhất (sắp xếp theo kiểu xếp hạng).

-- CAU 29)Tính tổng số sản phẩm do “Trung Quốc” sản xuất.

-- CAU 30) Tính tổng số sản phẩm của từng nước sản xuất.

-- CAU 31)Với từng nước sản xuất, tìm giá bán cao nhất, thấp nhất, trung bình của các sản phẩm.
SELECT	NUOCSX,MIN(GIA) , AVG(GIA) , MAX(GIA)
FROM SANPHAM
GROUP BY  NUOCSX;
-- CAU 32)Tính doanh thu bán hàng mỗi ngày.
select NgayMuaHang,TriGia as 'dpanh thu moi ngay' 
from hoadon
group by NgayMuaHang;
-- SELECT	COUNT(MASP)
-- FROM SANPHAM
-- WHERE NUOCSX='TRUNG QUOC';
-- CAU 33)Tính tổng số lượng của từng sản phẩm bán ra trong ngày 28/10/2006.
SELECT NUOCSX,COUNT(MASP) 
FROM SANPHAM,hoadon
where NgayMuaHang = '2006/10/28'
GROUP BY NUOCSX;
-- CAU 34)Tính doanh thu bán hàng của từng tháng trong năm 2006.

-- CAU 35)Tìm khách hàng (MAKH, HOTEN) có số lần mua hàng nhiều nhất.
SELECT S.MaSP, S.TenSP, SUM(SoLuong) FROM sanpham S JOIN cthd ON S.MaSP = cthd.MaSP JOIN hoadon ON cthd.SoHD = hoadon.SoHoaDon
WHERE YEAR(NgayMuaHang) = 2006
GROUP BY S.MaSP, S.TenSP
having SUM(SoLuong) >= ALL
(SELECT SUM(SoLuong) FROM cthd JOIN hoadon ON cthd.SoHD = hoadon.SoHoaDon WHERE YEAR(NgayMuaHang) = 2006 group by MaSP);
-- CAU 36)Tìm sản phẩm (MASP, TENSP) có tổng số lượng bán ra thấp nhất trong năm 2006.
SELECT S.MaSP, S.TenSP, SUM(SoLuong) FROM sanpham S JOIN cthd ON S.MaSP = cthd.MaSP JOIN hoadon ON cthd.SoHD = hoadon.SoHoaDon
WHERE YEAR(NgayMuaHang) = 2006
GROUP BY S.MaSP, S.TenSP
having SUM(SoLuong) <= ALL
(SELECT SUM(SoLuong) FROM cthd JOIN hoadon ON cthd.SoHD = hoadon.SoHoaDon WHERE YEAR(NgayMuaHang) = 2006 group by MaSP);
-- CAU 38) Mỗi nước sản xuất, tìm sản phẩm (MASP,TENSP) có giá bán cao nhất.
SELECT	*
FROM HOADON
WHERE SoHoaDon IN (SELECT SoHoaDon
FROM CTHD
GROUP BY SOHD
HAVING	COUNT(DISTINCT MASP)>=4);
-- CAU 39)*Trong 10 khách hàng có doanh số cao nhất, tìm khách hàng có số lần mua hàng nhiều nhất.
SELECT	*
FROM HOADON
WHERE SoHoaDon IN (SELECT SOHD
FROM CTHD A, SANPHAM B
WHERE A.MASP=B.MASP AND NUOCSX='VIET NAM'
GROUP BY SOHD
HAVING	COUNT(DISTINCT A.MASP)=3);
-- CAU 40)Tìm nước sản xuất sản xuất ít nhất 3 sản phẩm có giá bán khác nhau
SELECT	*
FROM KHACHHANG
WHERE MAKH IN (SELECT MAKH
FROM HOADON
GROUP BY MAKH
HAVING	COUNT(SoHoaDon)>=ALL(SELECT COUNT(SoHoaDon)
FROM HOADON
GROUP BY MAKH));
-- CAU 41)
SELECT	MONTH(NgayMuaHang) THANG
FROM HOADON
WHERE YEAR(NgayMuaHang)=2006
GROUP BY MONTH(NgayMuaHang)
HAVING	SUM(TRIGIA)>=ALL(SELECT	SUM(TRIGIA)
FROM HOADON
WHERE YEAR(NgayMuaHang)=2006
GROUP BY MONTH(NgayMuaHang));
-- CAU 42)
SELECT	B.MASP, TENSP
FROM SANPHAM A,CTHD B, HOADON C
WHERE A.MASP=B.MASP AND B.SOHD=C.SoHoaDon AND YEAR(NgayMuaHang)=2006
GROUP BY B.MASP,TENSP
HAVING	SUM(SoLuong)>=ALL(SELECT SUM(SoLuong)
FROM CTHD A, HOADON B
WHERE A.SOHD=B.SoHoaDon AND YEAR(NgayMuaHang)=2006
GROUP BY MASP);
-- CAU 43)
SELECT	NUOCSX,MASP, TENSP
FROM SANPHAM A
WHERE GIA=(SELECt MAX(GIA)
FROM SANPHAM B
WHERE A.NUOCSX=B.NUOCSX)
GROUP BY NUOCSX,MASP,TENSP;
-- CAU 44)Tìm nước sản xuất sản xuất ít nhất 3 sản phẩm có giá bán khác nhau
SELECT NUOCSX
FROM SANPHAM
GROUP BY NUOCSX
HAVING	COUNT(DISTINCT GIA)>=3;