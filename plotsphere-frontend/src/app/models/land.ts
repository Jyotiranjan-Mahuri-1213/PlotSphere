export class Land {
  id: number;
  surveyNumber: string;
  location: string;
  district: string;
  tehsil: string;
  village: string;
  area: number;
  landType: string;
  ownerId: number;
  status: string;

  constructor(
    id: number = 0,
    surveyNumber: string = '',
    location: string = '',
    district: string = '',
    tehsil: string = '',
    village: string = '',
    area: number = 0,
    landType: string = '',
    ownerId: number = 0,
    status: string = ''
  ) {
    this.id = id;
    this.surveyNumber = surveyNumber;
    this.location = location;
    this.district = district;
    this.tehsil = tehsil;
    this.village = village;
    this.area = area;
    this.landType = landType;
    this.ownerId = ownerId;
    this.status = status;
  }
}