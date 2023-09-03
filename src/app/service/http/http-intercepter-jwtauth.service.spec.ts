import { TestBed } from '@angular/core/testing';

import { HttpIntercepterJWTAuthService } from './http-intercepter-jwtauth.service';

describe('HttpIntercepterJWTAuthService', () => {
  let service: HttpIntercepterJWTAuthService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpIntercepterJWTAuthService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
