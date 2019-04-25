package clienteCad.model;

import java.io.Serializable;

public enum Command implements Serializable{
    CadPiloto, CadCarro, CadJogador, CadEquipe, 
    RemPiloto, RemCarro, RemParticipante, RemEquipe,
    EditPiloto, EditCarro, EditParticipante, EditEquipe,
    EditCorrida,
    ComecarCorrida, PararCorrida, IterarCarros,
}
