package org.saopaulofc.sociotorcedor.model.constantes;

public enum Assinatura {

    PACOTE1(15),
    PACOTE2(30),
    PACOTE3(60);

    private int minhaAssinatura;

    Assinatura(int minhaAssinatura) {
        this.minhaAssinatura = minhaAssinatura;
    }
    public int getMinhaAssinatura(){return minhaAssinatura;};
}
