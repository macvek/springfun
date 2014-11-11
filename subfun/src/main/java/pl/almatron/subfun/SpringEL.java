package pl.almatron.subfun;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * subfun
 *
 * @author macvek
 */
public class SpringEL {

    public void checkItOut(Object bean) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("childValue");
        String message = exp.getValue(bean, String.class);
        
        System.out.println(message);
    }
}
