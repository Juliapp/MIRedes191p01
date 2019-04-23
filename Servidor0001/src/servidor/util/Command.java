package servidor.util;

import java.io.Serializable;

public enum Command implements Serializable {
    CadPiloto, CadCarro, CadParticipante, CadEquipe, 
    RemPiloto, RemCarro, RemParticipante, RemEquipe,
    EditPiloto, EditCarro, EditParticipante, EditEquipe,
    EditCorrida,
    ComecarCorrida, PararCorrida,
}
