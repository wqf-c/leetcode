c++�еĽӿ���ͨ����������ʵ�ֵ�

�������������һ������������Ϊ���麯�������������ǳ����ࡣ���麯����ͨ����������ʹ�� "= 0" ��ָ���ģ�������ʾ��
```c++
class Box
{
   public:
      // ���麯��
      virtual double getVolume() = 0;
   private:
      double length;      
      double breadth;     
      double height;      
};
```
�����಻�ܱ�ʵ�����������ͼʵ����һ��������Ķ��󣬻ᵼ�±������

���һ���������������Ҫ��ʵ�����������ʵ��ÿ���麯�������磺
```c++
// ����
class Shape 
{
public:
   // �ṩ�ӿڿ�ܵĴ��麯��
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
 
// ������
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



