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

c++11提供了异步接口std::async，通过这个异步接口可以很方便的获取线程函数的执行结果。std::async会自动创建一个线程去调用线程函数，
它返回一个std::future，这个future中存储了线程函数返回的结果，当我们需要线程函数的结果时，直接从future中获取。
std::async的第一个参数是创建策略，有两种策略，默认的策略是立即创建线程：
```c++
std::launch::async：在调用async就开始创建线程。
std::launch::deferred：延迟加载方式创建线程。调用async时不创建线程，直到调用了future的get或者wait时才调用的入口函数（不创建新线程）。
launch::async | launch::deferred：可能创建新线程，也可能延迟调用。系统会根据当前的资源情况选择合适的方式。
```
主线程既可使用std::future::get获取结果，如果调用过程中，任务尚未完成，则主线程阻塞至任务完成。
主线程也可使用std::future::wait_for等待结果返回，wait_for可设置超时时间，如果在超时时间之内任务完成，则返回std::future_status::ready状态；如果在超时时间之内任务尚未完成，则返回std::future_status::timeout状态。
需要注意的是future的get方法只能调用一次，否者会抛出异常。