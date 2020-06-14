  Ϊmap����Ԫ�������ַ�ʽ������ʵ�ִ������£�
```c++
map<int, Test1> m1;
Test1 t1;
m1.insert(map<int, Test1>::value_type(1, t1));  //��һ��
m1.insert(std::pair<int, Test1>(2, t1));        //�ڶ���
m1[3] = t1;                                     //������
```
  ���ַ��������Ե����������map���Լ�������Ҫ��ӵ�key,��ôʹ�õ�һ�ڶ��ַ����ᱨ�������ַ����Ὣ�µ�value�滻���ɵ�value.
  ���ַ����ھ���ʵ��Ҳ�кܴ����𣬲��Դ�������:
```c++
class Test1 {
public:
	Test1() { cout << "�޲ι��캯��" << endl; }
	Test1(const Test1 &t) { 
		cout << "�������캯��" << endl; 
	}
	~Test1() { cout << "��������" << endl; }

	Test1 &operator=(Test1 &t) {
		cout << "=��ֵ����" << endl;
		return *this;
	}
};

void main() {
	map<int, Test1> m1;
	Test1 t1;
	std::cout << "===========��һ�ַ���=============" << endl;
	m1.insert(map<int, Test1>::value_type(1, t1));
	std::cout << "===========�ڶ��ַ���=============" << endl;
	m1.insert(std::pair<int, Test1>(2, t1));
	std::cout << "===========�����ַ���=============" << endl;
	m1[3] = t1;
	system("pause");
}
```
���Խ������ͼ��

�������ʹ�õ�һ�ֺ͵ڶ��ַ���Ϊmap���Ԫ�ػ�ִ�����ο������캯����ԭ����
```c++ 
m1.insert(map<int, Test1>::value_type(1, t1));
```
��
```c++
map<int, Test1>::value_type t2(1, t1);
m1.insert(t2);
```
�ȼۣ����ߵ�������䶼��ʹ�ÿ������캯�����������󽫵ڶ��ο������캯���õ��Ķ�����Ϊvalue�ŵ�map�С�
�����ַ�����ִ�����޲ι��캯�����ٽ���=��ֵ�����������ƶϳ�c++���������ڲ�ʹ�����޲ι��캯���ȹ�����һ������t2����ִ��t2=t1������
����ٽ�t2��Ϊvalue�ŵ�map�С�


