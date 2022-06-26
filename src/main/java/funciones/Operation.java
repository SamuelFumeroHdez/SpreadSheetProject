package funciones;

import models.Operand;

import java.util.List;

public interface Operation {

    void processContent(List<Operand> operandsList);
    void execute();
    Integer returnResult();

}
