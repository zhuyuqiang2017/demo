package top.selfhelp;

import top.selfhelp.interfaces.AnimalInterface;
import top.selfhelp.interfacesimpl.Cat;

import java.lang.reflect.Proxy;

public class DynamicProxyApplication {

    public static void main(String[] args) {
        AnimalInterface animal = new Cat();
        animal.action();
        AnimalInterface animalProxy = (AnimalInterface) Proxy.newProxyInstance(
                AnimalInterface.class.getClassLoader(),
                new Class[]{AnimalInterface.class}, (proxy,method,parameters)-> {
                    System.out.println("Just proxy animal doing actions");
                    return method.invoke(animal,parameters);
                });
        animalProxy.action();
    }
}
