```c++
int factorial(int n) {
	int num = 1;
	int i = 0;
	Sleep(1000);
	while (n > 0)
	{
		num *= n;
		n--;
	}
	//Sleep(4000);
	return num;
}

int main() {
	future<int> fu = std::async(std::launch::async, factorial, 4);
	int i = 0;
	Sleep(500);
	std::chrono::milliseconds span(100);
	while (fu.wait_for(span) != std::future_status::ready)
		std::cout << ".";
	std::cout << std::endl;
	std::cout << fu.get() << std::endl;
	
	return 0;
}
```

c++11�ṩ���첽�ӿ�std::async��ͨ������첽�ӿڿ��Ժܷ���Ļ�ȡ�̺߳�����ִ�н����std::async���Զ�����һ���߳�ȥ�����̺߳�����
������һ��std::future�����future�д洢���̺߳������صĽ������������Ҫ�̺߳����Ľ��ʱ��ֱ�Ӵ�future�л�ȡ��
std::async�ĵ�һ�������Ǵ������ԣ������ֲ��ԣ�Ĭ�ϵĲ��������������̣߳�
```c++
std::launch::async���ڵ���async�Ϳ�ʼ�����̡߳�
std::launch::deferred���ӳټ��ط�ʽ�����̡߳�����asyncʱ�������̣߳�ֱ��������future��get����waitʱ�ŵ��õ���ں��������������̣߳���
launch::async | launch::deferred�����ܴ������̣߳�Ҳ�����ӳٵ��á�ϵͳ����ݵ�ǰ����Դ���ѡ����ʵķ�ʽ��
```
���̼߳ȿ�ʹ��std::future::get��ȡ�����������ù����У�������δ��ɣ������߳�������������ɡ�
���߳�Ҳ��ʹ��std::future::wait_for�ȴ�������أ�wait_for�����ó�ʱʱ�䣬����ڳ�ʱʱ��֮��������ɣ��򷵻�std::future_status::ready״̬������ڳ�ʱʱ��֮��������δ��ɣ��򷵻�std::future_status::timeout״̬��
��Ҫע�����future��get����ֻ�ܵ���һ�Σ����߻��׳��쳣��