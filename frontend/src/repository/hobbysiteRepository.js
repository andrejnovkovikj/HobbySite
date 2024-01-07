import axios from '../custom-axios/axios';

const HobbySiteService = {
    fetchActivities: () => {
        return axios.get(`/activities`);
    },
    fetchCategories: () => {
        return axios.get('/categories');
    }
}
export default HobbySiteService;