package mrs.app.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {EndTimeMustBeAfterStartTimeValidator.class})
@Retention(RUNTIME)
@Target({ ANNOTATION_TYPE, TYPE })
public @interface EndTimeMustBeAfterStartTime {
    String message() default "{mrs.app.reservation.validation.EndTimeMustBeAfterStartTime.message}";

    Class<?>[]groups() default {};

    Class<? extends Payload>[]payload() default {};

    @Target({ ANNOTATION_TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR })
    @Retention(RUNTIME)
    @Documented
    public @interface List {
        EndTimeMustBeAfterStartTime[]value();
    }
}
