  为map插入元素有三种方式，具体实现代码如下：
```c++
map<int, Test1> m1;
Test1 t1;
m1.insert(map<int, Test1>::value_type(1, t1));  //第一种
m1.insert(std::pair<int, Test1>(2, t1));        //第二种
m1[3] = t1;                                     //第三种
```
  三种方法最明显的区别是如果map中以及包含了要添加的key,那么使用第一第二种方法会报错，第三种方法会将新的value替换掉旧的value.
  三种方法在具体实现也有很大区别，测试代码如下:
```c++
class Test1 {
public:
	Test1() { cout << "无参构造函数" << endl; }
	Test1(const Test1 &t) { 
		cout << "拷贝构造函数" << endl; 
	}
	~Test1() { cout << "析构函数" << endl; }

	Test1 &operator=(Test1 &t) {
		cout << "=赋值操作" << endl;
		return *this;
	}
};

void main() {
	map<int, Test1> m1;
	Test1 t1;
	std::cout << "===========第一种方法=============" << endl;
	m1.insert(map<int, Test1>::value_type(1, t1));
	std::cout << "===========第二种方法=============" << endl;
	m1.insert(std::pair<int, Test1>(2, t1));
	std::cout << "===========第三种方法=============" << endl;
	m1[3] = t1;
	system("pause");
}
```
测试结果如下图：

结果表明使用第一种和第二种方法为map添加元素会执行两次拷贝构造函数，原因是
```c++ 
m1.insert(map<int, Test1>::value_type(1, t1));
```
和
```c++
map<int, Test1>::value_type t2(1, t1);
m1.insert(t2);
```
等价，后者的两条语句都会使用拷贝构造函数构造对象，最后将第二次拷贝构造函数得到的对象作为value放到map中。
第三种方法先执行了无参构造函数，再进行=赋值操作，可以推断出c++编译器在内部使用了无参构造函数先构造了一个对象t2，再执行t2=t1操作，
最后再将t2作为value放到map中。


