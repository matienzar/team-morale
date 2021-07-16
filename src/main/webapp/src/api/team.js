import {TEAM} from '../http-common';

export const VERSION = 'v1';

export default {

    getMorale(id, cbok, cberr)
    {
        TEAM.genericGet('/team/'+ VERSION+"/"+id, cbok, cberr);
    }

}