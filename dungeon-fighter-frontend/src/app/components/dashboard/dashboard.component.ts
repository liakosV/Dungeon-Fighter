import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-dashboard',
  imports: [CommonModule],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  hoveredZone: string | null = null;
  tooltipX = 0;
  tooltipY = 0;

  onHoverZone(name: string, event: MouseEvent): void {
    this.hoveredZone = name;
    this.tooltipX = event.clientX;
    this.tooltipY = event.clientY;
    console.log(`Hovered on ${name}`)
  }

  onMouseMove(event: MouseEvent): void {
    this.tooltipX = event.clientX;
    this.tooltipY = event.clientY;
  }

  onZoneClick(zoneId: string): void {
    this.hoveredZone = zoneId;
    console.log(`Clicked on ${zoneId}`);
  }

  onLeaveZone(): void {
    this.hoveredZone = null;
  }
}
