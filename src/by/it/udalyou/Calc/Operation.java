package by.it.udalyou.Calc;



interface Operation {
    Var add(Var other) throws CalkException;

    Var sub(Var other) throws CalkException;

    Var mul(Var other)throws CalkException;

    Var div(Var other)throws CalkException;
}

