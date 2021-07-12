import {TEAM} from '../http-common';

export const VERSION = 'v1';

export default {

    getMorale(cbok, cberr)
    {
        TEAM.genericGet('/team/'+ VERSION, cbok, cberr);
    }

}