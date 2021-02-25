import java.util.Scanner;
public class PROYECTO
{
	public static Scanner sc=new Scanner(System.in);
	public static Scanner leer=new Scanner(System.in);

static int n=0;
static int [] art= new int [55];
static String [] des= new String [55];
static int [] cant= new int [55];
static double [] pre= new double [55];
public static void main(String[] args)
{

int op=1;
while (op!=5)
{
	System.out.println("---------------------------------");
System.out.println("1..Alta un articulo");
System.out.println("2..Baja un articulo");
System.out.println("3..Modificar un articulo");
System.out.println("4..Reporte de articulos");
System.out.println("5..Salir");

System.out.print("Introduzca una opcion: ");
op=sc.nextInt();
System.out.println("---------------------------------");

switch (op)
	{
	case 1:
	altas();
	break;
	case 2:
	if(n>0)
	{
	bajas();
	}
	else
	{
		System.out.println("No has registrado ningun articulo aun.");
	}
	break;
	case 3:
	cambio();
	break;
	case 4:
	reporte();
	break;
	}
}//while op
}// main

public static void altas()
{
int a=0,b=0;
art[n]=0;
pre[n]=0;
cant[n]=0;
System.out.print("Numero de articulo: ");
a=sc.nextInt();

while(b<n)
{
	while(a==art[b])
	{
	System.out.println("Invalido, ingrese otro.");
	a=sc.nextInt();
	}
	b++;
}
art[n]=a;

System.out.println("Ingrese descripcion");
des[n]=leer.nextLine();

while(pre[n]<=0)
{
System.out.println("Ingrese precio unitario, mayor a cero");
pre[n]=sc.nextDouble();
}

while(cant[n]<=0)
	{
	System.out.println("Ingrese cantidad en existencia, mayor a cero");
	cant[n]=sc.nextInt();
	}
n++;

}

public static void bajas()
{
int a=0,c=0,d=0,b=0,op=0;
double d2=0;
String d1;
n--;
while(c==0)
{
	System.out.print("Numero de articulo: ");
	a=sc.nextInt();
b=0;

while (b<n+1)
	{
		if(a==art[b])
		{
			System.out.println("Numero de Articulo: "+art[b]);
			System.out.println("Descripcion: "+des[b]);
			System.out.println("Precio: "+pre[b]);
			System.out.println("Cantidad: "+cant[b]);
			System.out.println("1) Confirmar Baja       2) Cancelar");
			op=sc.nextInt();

			switch(op)
			{
				case 1:
			d=art[b];
			art[b]=art[n];
			art[n]=d;

			d1=des[b];
			des[b]=des[n];
			des[n]=d1;

			d=cant[b];
			cant[b]=cant[n];
			cant[n]=d;

			d2=pre[b];
			pre[b]=pre[n];
			pre[n]=d2;
			b=n+1;
			break;
			case 2:
			n++;
			break;
			}
		c=1;
		}
	b++;
	}
	if(c==0)
		{
		System.out.print("Ese no existe, ingrese otro ");
		}
	}

}

public static void cambio()
{
int a=0,b=0,pos=-1,op=0;
while(pos==-1)
{
System.out.print("Ingrese numero de articulo: ");
a=sc.nextInt();
b=0;
while(b<n)
{
	if(a==art[b])
	{
		pos=b;
		System.out.println("Numero de Articulo: "+art[b]);
		System.out.println("Descripcion: "+des[b]);
		System.out.println("Precio: "+pre[b]);
		System.out.println("Cantidad: "+cant[b]);
	}
	b++;
}
if(pos==-1)
{
	System.out.print("Este numero no existe. ");
}
}
System.out.println("Que desea modificar? ");
System.out.println("1...Descripcion");
System.out.println("2...Precio unitario");
System.out.println("3...Ambos");
op=sc.nextInt();
switch(op)
{
case 1:
	System.out.println("Ingrese nueva descripcion");
	des[pos]=leer.nextLine();
	break;
case 2:
	pre[pos]=0;
	while(pre[pos]<=0)
	{
	System.out.println("Ingrese nuevo precio");
	pre[pos]=sc.nextDouble();
	}
	break;
case 3:
	System.out.println("Ingrese nueva descripcion");
	des[pos]=leer.nextLine();
	pre[pos]=0;
	while(pre[pos]<=0)
	{
	System.out.println("Ingrese nuevo precio");
	pre[pos]=sc.nextDouble();
	}
	break;
}
}
public static void reporte(){
	int op=0,b=0,c=0,d=0;
	String d1;
	double d2=0;
System.out.println("De que manera quisiera ordenar el reporte?");
System.out.println("1...Por numero de de articulo");
System.out.println("2...Por su descripcion");
op=sc.nextInt();
switch(op)
{
case 1:
	while(b<n)
	{
		c=b+1;
		while(c<n)
		{
			if(art[b]>art[c])
			{
				d=art[b];
				art[b]=art[c];
				art[c]=d;

				d1=des[b];
				des[b]=des[c];
				des[c]=d1;

				d=cant[b];
				cant[b]=cant[c];
				cant[c]=d;

				d2=pre[b];
				pre[b]=pre[c];
				pre[c]=d2;
			}
		c++;
		}
		b++;
	}
	break;
case 2:
while(b<n)
	{
		c=b+1;
		while(c<n)
		{
			if(des[b].compareTo(des[c])>0)
			{
				d=art[b];
				art[b]=art[c];
				art[c]=d;

				d1=des[b];
				des[b]=des[c];
				des[c]=d1;

				d=cant[b];
				cant[b]=cant[c];
				cant[c]=d;

				d2=pre[b];
				pre[b]=pre[c];
				pre[c]=d2;
			}
		c++;
		}
		b++;
	}
	break;
}
b=0;
while(b<n)
{

	System.out.println("---------------------------------");
	System.out.println("Numero de Articulo: "+art[b]);
	System.out.println("Descripcion: "+des[b]);
	System.out.println("Precio: "+pre[b]);
	System.out.println("Cantidad: "+cant[b]);
	b++;
}

}


}// clase


