```c++
struct test
{
	char a;
	int b;
	short c;
};

struct test2
{
	char a;
	short b;
	int c;
};

int main() {
	test t1;
	test2 t2;
	printf("%d %d\n", sizeof(t1), sizeof(t2));
	printf("%d  %d  %d\n", &t1.a, &t1.b, &t1.c);
	printf("%d  %d  %d\n", &t2.a, &t2.b, &t2.c);
	system("pause");
}
```
上面的代码运行结果：
两个结构体test和test2有都有一个char类型，一个short类型，一个int类型的变量，在我的电脑上
char类型占1个字节，short类型占2个字节，int类型占4个字节，打印出来的大小是t1占12个字节，
t2占8个字节，这是因为结构体大小遵循两条规律：
```c++
1，每个结构体成员的起始地址为该成员大小的整数倍，即int型成员的其实地址只能为0、4、8等

2，结构体的大小为其中最大成员大小的整数倍
```
运行结果t1和t2中各个变量的地址可以验证这两条规律。