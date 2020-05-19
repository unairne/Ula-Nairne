package com.kodilla.stream.beautifier;
import com.kodilla.stream.lambda.MathExpression;


public class PoemBeautifier implements PoemDecorator{
    @Override
    public String decorate(String string, String bonus) {
        String result = bonus + string + bonus;
        return result;
    }
    public String decorateLambda(String string, String bonus, PoemDecorator poemDecorator) {
        String result = poemDecorator.decorate(string, bonus);
        return result;
    }
}