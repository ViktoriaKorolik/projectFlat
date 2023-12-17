package FlatProject.models.rooms;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractEntity<R, S> implements Serializable {
    private R parameter;
    private S specOption;

    public AbstractEntity(R roomType, S specOption) {
        this.parameter = roomType;
        this.specOption = specOption;
    }

    public R getParameter() {


        return parameter;
    }

    public void setParameter(R parameter) {
        this.parameter = parameter;
    }

    public S getSpecOption() {
        return specOption;
    }

    public void setSpecOption(S specOption) {
        this.specOption = specOption;
    }


    @Override
    public String toString() {
        return "AbstractEntity{" +
                "parameter=" + parameter +
                ", specOption=" + specOption +
                '}';
    }
}
