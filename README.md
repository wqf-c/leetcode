c++中的接口是通过抽象类来实现的

如果类中至少有一个函数被声明为纯虚函数，则这个类就是抽象类。纯虚函数是通过在声明中使用 "= 0" 来指定的，如下所示：
```c++
class Box
{
   public:
      // 纯虚函数
      virtual double getVolume() = 0;
   private:
      double length;      
      double breadth;     
      double height;      
};
```
抽象类不能被实例化，如果试图实例化一个抽象类的对象，会导致编译错误。

如果一个抽象类的子类需要被实例化，则必须实现每个虚函数。例如：
```c++
// 基类
class Shape 
{
public:
   // 提供接口框架的纯虚函数
   virtual int getArea() = 0;
   void setWidth(int w)
   {
      width = w;
   }
   void setHeight(int h)
   {
      height = h;
   }
protected:
   int width;
   int height;
};
 
// 派生类
class Rectangle: public Shape
{
public:
   int getArea()
   { 
      return (width * height); 
   }
};
int main(void)
{
   Rectangle Rect;
   Triangle  Tri;
 
   Rect.setWidth(5);
   Rect.setHeight(7);
   cout << "Total Rectangle area: " << Rect.getArea() << endl;
   return 0;
}
```



