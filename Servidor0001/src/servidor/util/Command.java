package servidor.util;

import java.io.Serializable;

/**
 *
 * @author juli
 */
public enum Command implements Serializable {

    /**
     *
     */
    CadPiloto, 

    /**
     *
     */
    CadCarro, 

    /**
     *
     */
    CadParticipante, 

    /**
     *
     */
    CadEquipe, 

    /**
     *
     */
    RemPiloto,

    /**
     *
     */
    RemCarro,

    /**
     *
     */
    RemParticipante,

    /**
     *
     */
    RemEquipe,

    /**
     *
     */
    EditPiloto,

    /**
     *
     */
    EditCarro,

    /**
     *
     */
    EditParticipante,

    /**
     *
     */
    EditEquipe,

    /**
     *
     */
    EditCorrida,

    /**
     *
     */
    ComecarCorrida,

    /**
     *
     */
    PararCorrida,
}
