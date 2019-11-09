import { TestBed } from '@angular/core/testing';

import { RestService } from './adding.service';

describe('NewsserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RestService = TestBed.get(RestService);
    expect(service).toBeTruthy();
  });
});
