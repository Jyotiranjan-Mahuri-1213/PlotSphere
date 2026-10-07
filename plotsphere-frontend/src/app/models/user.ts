export class User {
     id: number;
  name: string;
  email: string;
  mobileNo: string;
  role: string;

  constructor(
    id: number = 0,
    name: string = '',
    email: string = '',
    mobileNo: string = '',
    role: string = ''
  ) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.mobileNo = mobileNo;
    this.role = role;
  }
}
