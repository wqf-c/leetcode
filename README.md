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
����Ĵ������н����
�����ṹ��test��test2�ж���һ��char���ͣ�һ��short���ͣ�һ��int���͵ı��������ҵĵ�����
char����ռ1���ֽڣ�short����ռ2���ֽڣ�int����ռ4���ֽڣ���ӡ�����Ĵ�С��t1ռ12���ֽڣ�
t2ռ8���ֽڣ�������Ϊ�ṹ���С��ѭ�������ɣ�
```c++
1��ÿ���ṹ���Ա����ʼ��ַΪ�ó�Ա��С������������int�ͳ�Ա����ʵ��ַֻ��Ϊ0��4��8��

2���ṹ��Ĵ�СΪ��������Ա��С��������
```
���н��t1��t2�и��������ĵ�ַ������֤���������ɡ�