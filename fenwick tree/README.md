
# <p align="center"> Hướng dẫn chi tiết về video demo </p>
### Đây là video demo cách tổ chức và các thao tác trên cây fenwick
### Một số thanh công cụ
Chúng ta có thể điều chỉnh tốc độ bằng các di chuyển slider trên màn hình, sang phải tốc độ sẽ nhanh hơn và sang trái sẽ ngược lại
<p align="center"> <img src="https://github.com/kimanh24022001/CS523.M21.KHCL/blob/main/fenwick%20tree/gif_1.gif" alt="Tieude" /> </p>
Có 2 option, đầu tiên là chế độ chạy liên tục
<p align="center"> <img src="https://github.com/kimanh24022001/CS523.M21.KHCL/blob/main/fenwick%20tree/img3.jpg" alt="Tieude" /> </p>
Ta có thể dừng lại hoặc tua lại thông qua 2 nút dưới đây
<p align="center"> <img src="https://github.com/kimanh24022001/CS523.M21.KHCL/blob/main/fenwick%20tree/img6.jpg" alt="Tieude" /> </p>
Hai là chạy từng bước một (step by step)
<p align="center"> <img src="https://github.com/kimanh24022001/CS523.M21.KHCL/blob/main/fenwick%20tree/img4.jpg" alt="Tieude" /> </p>
Ta có thể di chuyển tới node tiếp theo qua nút này
<p align="center"> <img src="https://github.com/kimanh24022001/CS523.M21.KHCL/blob/main/fenwick%20tree/img5.jpg" alt="Tieude" /> </p>
Ta có thể hiểu từng bước thông qua nút explain
<p align="center"> <img src="https://github.com/kimanh24022001/CS523.M21.KHCL/blob/main/fenwick%20tree/img2.jpg" alt="Tieude" /> </p>
Tạo một cây mới thì sẽ làm mới và tạo lại từ đầu
<p align="center"> <img src="https://github.com/kimanh24022001/CS523.M21.KHCL/blob/main/fenwick%20tree/img1.jpg" alt="Tieude" /> </p>

### Tạo cây
- Đầu tiên chúng ta có thể tạo mảng ban đầu bằng cách nhập vào hoặc random các giá trị của mảng
- Sau đó cây sẽ được tạo ra với số node bằng với số phần tử mảng, giá trị các node bằng 0
<p align="center"> <img src="https://github.com/kimanh24022001/CS523.M21.KHCL/blob/main/fenwick%20tree/gif_2.gif" alt="Tieude" /> </p>


 Bước tiếp theo là cập nhật từng node cây, mỗi node sẽ update theo giá trị của mảng theo thứ tự tương ứng với node đó. Giá trị mảng sẽ được hiển thị ở bên dưới.
 
<p align="center"> <img src="https://github.com/kimanh24022001/CS523.M21.KHCL/blob/main/fenwick%20tree/gif_6.gif" alt="Tieude" /> </p>


Ta có thể update một node bất kì với giá trị bất kì, các node cha tương ứng sẽ được cập nhật.

<p align="center"> <img src="https://github.com/kimanh24022001/CS523.M21.KHCL/blob/main/fenwick%20tree/gif_3.gif" alt="Tieude" /> </p>


Ta có thể tính tổng các phần tử của mảng ban đầu 

<p align="center"> <img src="https://github.com/kimanh24022001/CS523.M21.KHCL/blob/main/fenwick%20tree/gif_4.gif" alt="Tieude" /> </p>


### Cách 2
Ta có thể cho chạy từng node một, mỗi khi nhấn nút một lần, cây sẽ được tạo thêm 1 node nữa.
<p align="center"> <img src="https://github.com/kimanh24022001/CS523.M21.KHCL/blob/main/fenwick%20tree/gif_5.gif" alt="Tieude" /> </p>

