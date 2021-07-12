import axios from 'axios';

export const HTTP = axios.create({
  headers: {
    'content-type': 'application/json'
  }
})



export const TEAM = {
    getHeaders()
    {
        var headers = {};

        if (/MSIE|Trident/.test(window.navigator.userAgent))
        {
            headers['Pragma'] = 'no-cache';
            headers['Cache-Control'] = 'no-cache, no-store';
        }

        return { headers:headers};
    },
    genericGet(service,cbok, cberr)
    {

        HTTP
            .get(service,
            this.getHeaders())
            .then((response) => {
                cbok(response.data);
            }).catch(function (error) {
                cberr(error);
            });
    }
}