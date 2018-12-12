/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhosmc;

/**
 *
 * @author guiza
 */
public class Foguete {
    
   public double f(double t, double y){
       return (2000 - 2 * y) / (200 - t);
   }
    
   public double Euler(double h, double estimar){
       double xk = 0, yk = 0;
       while(xk < estimar){
           yk = yk + h * f(xk,yk);
           xk = xk + h;
       }
       return yk;
   }
   
   public double EulerMelhorado(double h, double estimar){
       double xk = 0, yk = 0;
       while(xk < estimar){
           yk = yk + h * ((f(xk,yk) + f(xk+h, yk + h* f(xk,yk))) / 2);
           xk = xk + h;
       }
       return yk;
   }
   
   public double solucaoAnalitica(double x){
       return Math.pow(Math.E, 0.1 * (Math.pow(x,2)-1));
   }
   
   public double RangeKutta(double h, double estimar){
       double k1,k2,k3,k4, xk = 0, yk = 0;
       while(xk < estimar){
           k1 = f(xk,yk);
           k2 = f(xk + h/2, yk + (h*k1)/2);
           k3 = f(xk + h/2, yk + (h*k2)/2);
           k4 = f(xk + h, yk + h * k3);
           yk = yk + (h/6) * (k1 + 2 * k2 + 2 * k3 + k4);
           xk = xk + h;
       }
       return yk;   
   }
   
   public double solucaoAnaliticaFoguete(double x){
       return (10 * x) - (Math.pow(x,2)/40);
   }
   
   public void executaTodos(double h, double estimar){
       double euler, eulerM, range, analitica;
       long tempoEuler, tempoEulerM, tempoRange, tempoAnalitica;
       long tempoInicial = System.nanoTime();
       euler = this.Euler(h, estimar);
       tempoEuler = System.nanoTime() - tempoInicial;
       tempoInicial = System.nanoTime();
       eulerM = this.EulerMelhorado(h, estimar);
       tempoEulerM = System.nanoTime() - tempoInicial;
       tempoInicial = System.nanoTime();
       range =  this.RangeKutta(h, estimar);
       tempoRange = System.nanoTime() - tempoInicial;
       tempoInicial = System.nanoTime();
       analitica = this.solucaoAnaliticaFoguete(estimar);
       tempoAnalitica = System.nanoTime() - tempoInicial;
     

       System.out.println("Estimar f(" + estimar + ")");
       System.out.println("Valor h: " + h);
       System.out.println("Euler Normal: " + euler);
       System.out.println("Euler Melhorado: " + eulerM);
       System.out.println("Range Kutta: " + range);
       System.out.println("Solução Analítica: " + analitica);
       System.out.println("Erro Euler Normal: " + (( Math.abs(euler - analitica) / analitica) * 100) + "%");
       System.out.println("Erro Euler Melhorado: " + (( Math.abs(eulerM - analitica) / analitica) * 100) + "%");
       System.out.println("Erro Range Kutta: " + (( Math.abs(range - analitica) / analitica) * 100) + "%");
       System.out.println("Tempo de Execução Euler Normal (ms): " + tempoEuler);
       System.out.println("Tempo de Execução Euler Melhorado (ms): " + tempoEulerM);
       System.out.println("Tempo de Execução Range Kutta (ms): " + tempoRange);
       System.out.println("Tempo de Execução Solução Analítica (ms): " + tempoAnalitica);
       System.out.println("");
   }
   
}
