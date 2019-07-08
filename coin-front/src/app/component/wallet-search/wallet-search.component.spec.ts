import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WalletSearchComponent } from './wallet-search.component';

describe('WalletSearchComponent', () => {
  let component: WalletSearchComponent;
  let fixture: ComponentFixture<WalletSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WalletSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WalletSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
