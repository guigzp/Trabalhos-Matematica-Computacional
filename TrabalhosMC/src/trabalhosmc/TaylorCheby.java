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
public class TaylorCheby {

    public int fatorial(int x) {
        int resultado = 1;
        for (; x > 1; x--) {
            resultado *= x;
        }
        return resultado;
    }

    public double senoTaylor(double x) {
        double resultado = x;
        resultado += -(Math.pow(x, 3) / fatorial(3));
        resultado += (Math.pow(x, 5) / fatorial(5));
        resultado += -(Math.pow(x, 7) / fatorial(7));
        resultado += (Math.pow(x, 9) / fatorial(9));
        resultado += -(Math.pow(x, 11) / fatorial(11));
        return resultado;
    }

    public double cosenoTaylor(double x) {
        double resultado = 1;
        resultado += (-1) * (Math.pow(x, 2) / fatorial(2));
        resultado += (Math.pow(x, 4) / fatorial(4));
        resultado += (-1) * (Math.pow(x, 6) / fatorial(6));
        resultado += (Math.pow(x, 8) / fatorial(8));
        resultado += (-1) * (Math.pow(x, 10) / fatorial(10));
        return resultado;
    }

    public double reducaoArgumentoTaylor(double x) {
        double pi = Math.PI;
        double resultado;
        while (x > 2 * pi) {
            x = x - (2 * pi);
        }
        if(x >= -2 * pi && x < - pi/4){
            return - reducaoArgumentoTaylor(-x);
        }else if(x >= -pi/4 && x <= pi/4){
            return senoTaylor(x);
        }else if (x > pi / 4 && x <= pi / 2) {
            resultado = cosenoTaylor(pi / 2 - x);
        } else if (x <= (3 * pi) / 4) {
            resultado = cosenoTaylor(x - pi / 2);
        } else if (x <= pi) {
            resultado = senoTaylor(pi - x);
        } else if (x <= (5 * pi) / 4) {
            resultado = -senoTaylor(x - pi);
        } else if (x <= (3 * pi) / 2) {
            resultado = -cosenoTaylor(((3 * pi) / 2) - x);
        } else if (x <= (7 * pi) / 4) {
            resultado = -cosenoTaylor(x - ((3 * pi) / 2));
        } else {
            resultado = -senoTaylor((2 * pi) - x);
        }
        return resultado;
    }
      
     public double reducaoArgumentoCheby(double x) {
        double resposta =0;
        double pi = Math.PI;
        while(x > 2 * pi){
            x = x - 2 * pi;
        }
        if(x >= -2 * pi && x < -pi /4){
            return -reducaoArgumentoCheby(-x);
        }else if(x <= pi) {
            resposta = senoCheby(x);
        }else if (x <= 2 * pi) {
            resposta = -senoCheby( (2 * pi) -x);
        }
        return resposta;
    }
     
    public double Tn(double x, int i){
        switch (i) {
            case 0:
                return 1;
            case 1:
                return x;
            case 2:
                return 2  * Math.pow(x, 2) -1;
            case 3:
                return 4 * Math.pow(x, 3) - 3 * x;
            case 4:
                return 8 * Math.pow(x, 4) - 8 * Math.pow(x, 2) + 1;
            case 5:
                return 16 * Math.pow(x, 5) - 20 * Math.pow(x, 3) + 5 * x;
            case 6:
                return 32 * Math.pow(x, 6) - 48 * Math.pow(x, 4) + 18 * Math.pow(x, 2) - 1;
            case 7:
                return 64 * Math.pow(x, 7) - 112 * Math.pow(x, 5) + 56 * Math.pow(x, 3) - 7 * x;
            case 8:
                return 128 * Math.pow(x, 8) - 256 * Math.pow(x, 6) + 160 * Math.pow(x, 4) - 32 * Math.pow(x, 2) + 1;
            case 9:
                return 256 * Math.pow(x, 9) - 576 * Math.pow(x, 7) + 432 * Math.pow(x, 5) - 120 * Math.pow(x, 3) + 9 * x;
            case 10:
                return 512 * Math.pow(x, 10) - 1280 * Math.pow(x, 8) + 1120 * Math.pow(x, 6) - 400 * Math.pow(x, 4) + 50 * Math.pow(x, 2) -1;
            case 11:
                return 1024 * Math.pow(x, 11) - 2816 * Math.pow(x, 9) + 2816 * Math.pow(x, 7) - 1232 * Math.pow(x, 5) + 220 * Math.pow(x, 3) - 11 * x;
            default:
                return 0;
        }
    }
    
    public double w(double x){
        return 1 / Math.sqrt(1 - Math.pow(x, 2));
    }
     
    public double CiSeno(int i){
        if(i % 2 == 0){
            return 0;
        }else if(i == 1){
            return 0.8801011714897299;
        }else if(i == 3){
            return -0.03912670796533398;
        }else if(i == 5){
            return 0.0004995154592517784;
        }else if(i == 7){
            return -3.004652682298829E-06;
        }else if(i == 9){
            return 1.0499949590786636E-08;
        }else if(i == 11){
            return -2.1227908199943986E-11;
        }else{
            return 0;
        }
    }
    
    public double CiCoseno(int i){
        if(i % 2 > 0){
            return 0;
        }else if(i == 0){
            return 1.5303953731158757;
        }else if(i == 2){
            return -0.2298069698638014;
        }else if(i == 4){
            return 0.004953277928209125;
        }else if(i == 6){
            return -4.187667766754126E-05;
        }else if(i == 8){
            return 1.8844618339355993E-07;
        }else if(i == 10){
            return -5.266754015496207E-10;
        }else{
            return 0;
        }
    }
    
    public double cosenoCheby(double x){
        double resultado = 0;
        for(int i =0; i < 12; i++){
            resultado = resultado + CiCoseno(i -1) * Tn(x,i);
        }
        return resultado;
    }
    
    public double senoCheby(double x){
        double resultado = 0;
        for(int i =0; i < 12; i++){
            resultado = resultado + CiSeno(i) * Tn(x,i);
        }
        return resultado;
    }
}
